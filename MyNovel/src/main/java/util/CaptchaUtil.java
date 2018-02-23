package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

public class CaptchaUtil {
	// 图片高度
	private static final int IMG_HEIGHT = 100;
	// 图片宽度
	private static final int IMG_WIDTH = 30;
	// 验证码长度
	private static final int CODE_LEN = 4;

	public static void getCaptcha(HttpServletResponse resp,
			HttpServletRequest req) {
	
		BufferedImage bi = new BufferedImage(IMG_HEIGHT, IMG_WIDTH,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		g.setColor(new Color(100, 230, 200));
		g.fillRect(0, 0, 100, 30);

		char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456"
				.toCharArray();
		String captcha = ""; // 存放生成的验证码
		Random random = new Random();
		for (int i = 0; i < CODE_LEN; i++) { // 循环将每个验证码字符绘制到图片上
			int index = random.nextInt(codeChar.length);
			// 随机生成验证码颜色
			g.setColor(new Color(random.nextInt(150), random.nextInt(200),
					random.nextInt(255)));
			// 将一个字符绘制到图片上，并制定位置（设置x,y坐标）
			g.drawString(codeChar[index] + "", (i * 20) + 15, 20);
			captcha += codeChar[index];
		}
		// 将生成的验证码code放入sessoin中
		req.getSession().setAttribute("code", captcha);
		// 通过ImageIO将图片输出

		// BufferedOutputStream out = null;
		ServletOutputStream out = null;
		try {
			out = resp.getOutputStream();
			ImageIO.write(bi, "JPG", out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("验证码图片生成错误");
			e.printStackTrace();
		} finally {

			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
