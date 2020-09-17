package com.bonitaestoque.controller;

import java.util.ArrayList;
import java.util.List;

import com.bonitaestoque.model.Produto;
import com.bonitaestoque.services.CRUDServiceImpl;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

public class ProductController {

	private CRUDServiceImpl<Produto> service = new CRUDServiceImpl<Produto>();

	public List<Produto> getAllProducts() {

		final List<Produto> list = new ArrayList<Produto>();

		try {

			Task<List<Produto>> task = new Task<List<Produto>>() {

				@Override
				protected List<Produto> call() throws Exception {
					System.out.println("entrei");
					return service.getAll(Produto.class);
				}
			};

			task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

				@Override
				public void handle(WorkerStateEvent event) {
					System.out.println("handle");
					System.out.println(task.getValue());
					list.addAll(task.getValue());

					Produto p = list.get(0);
					p.setNome("TENIS OAKLEY");

					service.update(Produto.class, p.getId());
				}
			});

			new Thread(task).start();
			System.out.println(list);
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
