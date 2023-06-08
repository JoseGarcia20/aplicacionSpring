package com.seguridad.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.seguridad.app.entity.Cliente;

@Component("listar")

public class ListadoPDF extends AbstractPdfView {

	private static final String[] header = { "Id", "Nombre", "Apellido", "Email", "Fecha" };

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Cliente> listadoClientes = (List<Cliente>) model.get("clientes");

		document.setPageSize(PageSize.LETTER.rotate());
		document.open();

		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		celda = new PdfPCell(new Phrase("Listado Clientes"));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);

		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);

		PdfPTable tablaClientes = new PdfPTable(5);

		for (int i = 0; i < header.length; i++) {
			tablaClientes.addCell(header[i]);
		}

		listadoClientes.forEach(cliente -> {

			tablaClientes.addCell(cliente.getId().toString());
			tablaClientes.addCell(cliente.getNombre());
			tablaClientes.addCell(cliente.getApellido());
			tablaClientes.addCell(cliente.getEmail());
			tablaClientes.addCell(cliente.getFecha().toString());

		});

		document.add(tablaTitulo);
		document.add(tablaClientes);

	}
}
