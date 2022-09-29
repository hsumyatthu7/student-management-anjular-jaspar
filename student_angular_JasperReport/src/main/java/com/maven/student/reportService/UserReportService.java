package com.maven.student.reportService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.maven.student.dao.UserRepository;
import com.maven.student.dto.User;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Service
public class UserReportService {
	
	@Autowired
	private UserRepository repo;
	
	public String exportReport(String reportFormat,HttpServletResponse response) throws JRException, IOException {
		
		List<User> users = new ArrayList<User>();
		users =  repo.findAll();
		
//		load and compile
		String path = "D:\\jasperReport";
		
		File file = ResourceUtils.getFile("classpath:User.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
		Map<String, Object> parameters = new HashMap<>();
		
		parameters.put("createdBy", "Admin");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource);
		
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\users.html");

		}if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\users.pdf");

		}if(reportFormat.equalsIgnoreCase("excel")) {
			
			JRXlsxExporter exporter = new JRXlsxExporter();
	        exporter.setExporterInput( new SimpleExporterInput(jasperPrint));
	        exporter.setExporterOutput( new SimpleOutputStreamExporterOutput(path + "\\users.xlsx" ));

	        SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
	        config.setOnePagePerSheet( true );
	        config.setDetectCellType( true );
	        exporter.setConfiguration( config );
	        exporter.exportReport();

	
		}
		
		return "report generated in path " + path;
	}

}

















