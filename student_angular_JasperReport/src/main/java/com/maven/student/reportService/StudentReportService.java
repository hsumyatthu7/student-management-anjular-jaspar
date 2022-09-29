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

import com.maven.student.dao.StudentRepository;
import com.maven.student.dto.Student;

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
public class StudentReportService {

	@Autowired
private StudentRepository repo;
	
	public String exportReport(String reportFormat,HttpServletResponse response) throws JRException, IOException {
		
		List<Student> students = new ArrayList<Student>();
		students =  repo.findAll();
		
//		load and compile
		String path = "D:\\jasperReport";
		
		File file = ResourceUtils.getFile("classpath:Student.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);
		Map<String, Object> parameters = new HashMap<>();
		
		parameters.put("createdBy", "Admin");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource);
		
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\students.html");

		}if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\students.pdf");

		}if(reportFormat.equalsIgnoreCase("excel")) {
			JRXlsxExporter exporter = new JRXlsxExporter();
	        exporter.setExporterInput( new SimpleExporterInput(jasperPrint));
	        exporter.setExporterOutput( new SimpleOutputStreamExporterOutput(path + "\\students.xlsx" ));

	        SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
	        config.setOnePagePerSheet( true );
	        config.setDetectCellType( true );
	        exporter.setConfiguration( config );
	        exporter.exportReport();
			
		}
		
		return "report generated in path " + path;
	}
}
