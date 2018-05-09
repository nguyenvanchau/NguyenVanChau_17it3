package BT_kt;

import java.io.FileOutputStream;
import java.io.FileInputStream;

public class c3 {
	public static void readFile(String path1, String path2) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			//Tìm đến đường dẫn chứa file cần đọc
			fis = new FileInputStream(path1);
			fos = new FileOutputStream(path2);
			int data = fis.read();
			while(data != -1) {
				System.out.print((char)data);
				fos.write(data);
				data = fis.read();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		finally {
			try {
				fis.close();
				fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFile("E:\\text in IO java\\Hello.txt","E:\\text in IO java\\text.txt");
	}

}
