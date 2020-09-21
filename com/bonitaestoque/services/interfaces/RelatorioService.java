package com.bonitaestoque.services.interfaces;

import java.util.List;

import com.bonitaestoque.model.Categoria;

public interface RelatorioService {
	void createReport(List<Categoria> list);
}
