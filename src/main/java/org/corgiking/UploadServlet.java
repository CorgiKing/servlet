package org.corgiking;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String upload_dir = "upload";

	private final int memory_threshold = 1024 * 1024 * 3; // 3MB
	private final int max_file_size = 1024 * 1024 * 40; // 40MB
	private final int max_request_size = 1024 * 1024 * 50; // 50MB

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 检查是否为多媒体上传
		if (!ServletFileUpload.isMultipartContent(req)) {
			System.out.println("Error: 表单必须包含 enctype=multipart/form-data");
			return;
		}

		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
		factory.setSizeThreshold(memory_threshold);
		// 临时目录
		String tmpdir = System.getProperty("java.io.tmpdir");
		File tmpfile = new File(tmpdir);
		factory.setRepository(tmpfile);

		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置最大文件上传
		upload.setFileSizeMax(max_file_size);
		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(max_request_size);
		// 中文处理
		upload.setHeaderEncoding("UTF-8");
		// 构造临时路径来存储上传的文件
		// 这个路径相对当前应用的目录
		String uploadPath = req.getServletContext().getRealPath("./") + File.separator + upload_dir;
		// 如果目录不存在则创建
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			List<FileItem> files = upload.parseRequest(req);
			// upload.getItemIterator(req);
			if (files == null) {
				System.out.println("files: " + files);
				return;
			}

			for (FileItem item : files) {
				// 处理不在表单中的字段
				if (!item.isFormField()) {
					
					String fileName = new File(item.getName()).getName();
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					// 在控制台输出文件的上传路径
					System.out.println(filePath);
					// 保存文件到硬盘
					item.write(storeFile);
					req.setAttribute("message", "文件上传成功!");
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
