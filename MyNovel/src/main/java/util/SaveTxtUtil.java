package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class SaveTxtUtil {
	public static ArrayList<String> saveTxt(MultipartFile[] files, HttpSession session) {
		File newfile = null;
		String temp = session.getServletContext().getRealPath("/") + "novel";
		File pag = new File(temp);
		if (!pag.exists()) {
			pag.mkdir();
		}
		String filename = "";
		String newadress = "";
		ArrayList<String> filenames=new ArrayList<>();
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				filename = UuidUtil.getUuid() + ".txt";
				newadress = temp + "\\" + filename;
				newfile = new File(newadress);
				try {
					file.transferTo(newfile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					System.out.println("文件传送失败");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				filenames.add(filename);
			}

		}
		
		return filenames;
	}

}
