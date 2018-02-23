package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.myNovel.model.User;

public class ImageUtil {
	public static String savePic(MultipartFile faceimage, int needw, int needh,
			String savedoc, HttpSession session) {
		String newAdree = null;
		String newfilename=null;
		User user = ((User) session.getAttribute("user"));
		if (faceimage.isEmpty()) {
			newAdree = user.getFaceimage();
		} else {
			String filename = faceimage.getOriginalFilename();
			String filetype = filename.substring(filename.lastIndexOf(".") + 1)
					.toLowerCase();
			String Oadree = session.getServletContext().getRealPath("/");
			File oldfile = new File(Oadree + user.getFaceimage());

			newfilename = user.getId() + "." + filetype;
			newAdree = savedoc + "/" + newfilename;
			String newfile = Oadree + savedoc + "/" + newfilename;

			File savedocument = new File(Oadree + savedoc + "/");

			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			Image bi = null;
			try {
				in = new BufferedInputStream(faceimage.getInputStream());
				bi = ImageIO.read(in);
				int oh = bi.getHeight(null);
				int ow = bi.getWidth(null);
				int size[] = ImageUtil.changeSize(ow, oh, needw, needh);
				BufferedImage temp = new BufferedImage(size[0], size[1],
						BufferedImage.TYPE_INT_RGB);
				temp.getGraphics().drawImage(bi, 0, 0, size[0], size[1], null);
				if (!savedocument.exists()) {
					savedocument.mkdir();
				}
				if (oldfile.exists()) {
					oldfile.delete();
				}
				out = new BufferedOutputStream(new FileOutputStream(newfile));
				ImageIO.write(temp, filetype, out);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if (in != null) {
						in.close();
					}
					if (out != null) {
						out.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return newfilename;
	}

	public static int[] changeSize(int ow, int oh, int needw, int needh) {
		int[] size = new int[2];
		Double ratew = ((double) ow) / ((double) needw), rateh = ((double) oh)
				/ ((double) needh);
		if (ratew > rateh) {
			size[0] = needw;
			size[1] = (int) (oh / ratew);
		} else if (ratew == rateh) {
			size[0] = needw;
			size[1] = needh;
		} else {
			size[0] = (int) (ow / rateh);
			size[1] = needh;
			System.out.println("oh>");
		}
		System.out.println(size[0] + "         " + size[1]);
		return size;
	}
	// public static void main(String[] args) throws Exception {
	// // 读取图片
	// BufferedInputStream in = new BufferedInputStream(new FileInputStream(
	// "f:/8.jpg"));
	// // 字节流转图片对象
	// Image bi = ImageIO.read(in);
	// // 获取图像的高度，宽度
	// int height = bi.getHeight(null);
	// int width = bi.getWidth(null);
	// // 构建图片流
	// BufferedImage tag = new BufferedImage(width / 2, height / 2,
	// BufferedImage.TYPE_INT_RGB);
	// // 绘制改变尺寸后的图
	// tag.getGraphics().drawImage(bi, 0, 0, width / 2, height / 2, null);
	// // 输出流
	// BufferedOutputStream out = new BufferedOutputStream(
	// new FileOutputStream("f:/copy.jpg"));
	// // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	// // encoder.encode(tag);
	// ImageIO.write(tag, "png", out);
	// in.close();
	// out.close();// 转字节流//ByteArrayOutputStream out = new
	// // ByteArrayOutputStream();//ImageIO.write(tag, "PNG",out);
	// // InputStream is = new ByteArrayInputStream(out.toByteArray());
	// }
}
