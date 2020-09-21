package com.bonitaestoque.services;

import java.io.File;
import java.util.List;

import com.bonitaestoque.model.Categoria;
import com.bonitaestoque.services.interfaces.RelatorioService;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class RelatorioServiceImpl implements RelatorioService {

	private final String DESTINATION = "src/com/bonitaestoque/view/assets/test.pdf";

	@Override
	public void createReport(List<Categoria> list) {
		try {
			System.out.println("aoisdjioasjdiojaiosdjioa");
			File file = new File(DESTINATION);
			file.getParentFile().mkdirs();

			// Initialize PDF writer
			PdfWriter writer = new PdfWriter(DESTINATION);

			// Initialize PDF document
			PdfDocument pdf = new PdfDocument(writer);

			// Initialize document
			Document document = new Document(pdf);

			document.add(new Paragraph("BONITA FASHION - ESTOQUE").setTextAlignment(TextAlignment.CENTER).setMarginBottom(150));

			Table table = new Table(new float[4]).useAllAvailableWidth();
			table.setMarginTop(0);
			table.setMarginBottom(0);

			// first row
			Cell cell = new Cell(1, 10).add(new Paragraph("Relatorio de Produtos do estoque"));
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setPadding(5);
			cell.setBackgroundColor(new DeviceRgb(255, 121, 198));
			table.addCell(cell);

			table.addCell("ID");
			table.addCell("Nome");
			table.addCell("Qtd");
			table.addCell("Descrição").useAllAvailableWidth();

			list.forEach(item -> {
				table.addCell(String.valueOf(item.getId()));
				table.addCell(item.getNome());
				table.addCell(String.valueOf(item.getProdutos().size()));
				table.addCell(item.getDescricao());
			});
			
			document.add(table);

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
