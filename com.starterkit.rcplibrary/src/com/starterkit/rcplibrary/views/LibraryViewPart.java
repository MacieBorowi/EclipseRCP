package com.starterkit.rcplibrary.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import com.startekit.dao.BookDao;
import com.startekit.dao.ModelProvider;

public class LibraryViewPart extends ViewPart{

	private Text text;
	private Table table;
	private TableViewer tableViewer;
	private ModelProvider service = ModelProvider.INSTANCE;
	
	public LibraryViewPart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		setLabels(parent);
		
		setSearchTextField(parent);
		
		addSearchButton(parent);
		
		addLibraryTable(parent); 

		addMenus(parent);


	}

	private void addLibraryTable(Composite parent) {
		tableViewer = new TableViewer(parent,SWT.MULTI | SWT.H_SCROLL
			      | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		createColumns(parent,tableViewer);
		
//		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
//			  @Override
//			  public void selectionChanged(SelectionChangedEvent event) {
//			    IStructuredSelection selection = tableViewer.getStructuredSelection();
//			    Object firstElement = selection.getFirstElement();
//			    //test
//			    MessageDialog.openConfirm(null, "selectionChangedListener", " :P !");
//			  }
//			}); 
		
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(service.getPersons());
		getSite().setSelectionProvider(tableViewer);

	}
	
	 private void createColumns(Composite parent,TableViewer viewer){
		 
			String[] titles = { "Book Title", "Authors", "Subject", "ID" };
		    int[] bounds = { 250, 250, 120, 100 };

		    TableViewerColumn colnumn = createTableViewerColumn(titles[0], bounds[0], 0);
		    colnumn.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        BookDao book = (BookDao) element;
		        return book.getTitle();
		      }
		    });

		    colnumn = createTableViewerColumn(titles[1], bounds[1], 1);
		    colnumn.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
			        BookDao book = (BookDao) element;
			        return book.getAutor();
		      }
		    });

		    colnumn = createTableViewerColumn(titles[2], bounds[2], 2);
		    colnumn.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
			        BookDao book = (BookDao) element;
			        return book.getSubject();
		      }
		    });
		    
		    colnumn = createTableViewerColumn(titles[3], bounds[3], 3);
		    colnumn.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        BookDao book = (BookDao) element;
		        return book.getId().toString();
		      }
		    });
	 }
	 private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		 final TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
				 SWT.NONE);
		 final TableColumn column = viewerColumn.getColumn();
		 column.setText(title);
		 column.setWidth(bound);
		 column.setResizable(true);
		 column.setMoveable(true);
		 return viewerColumn;
	 }


	 
	private void setSearchTextField(Composite parent) {
		text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	private void addSearchButton(Composite parent) {
		Button btnClick = new Button(parent, SWT.NONE);
		GridData gd_btnClick = new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1);
		gd_btnClick.widthHint = 59;
		btnClick.setLayoutData(gd_btnClick);
		btnClick.setText("Search");
	}

	private void addMenus(Composite parent) {
		Menu menuTableLibrary = new Menu(table);
		table.setMenu(menuTableLibrary);
		
		MenuItem mntmAnuluj = new MenuItem(menuTableLibrary, SWT.NONE);
		mntmAnuluj.setText("Anuluj");
		
		MenuItem mntmUsun = new MenuItem(menuTableLibrary, SWT.NONE);
		mntmUsun.setText("Usuń");
		mntmUsun.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				//service.deleteBook(1L);
				tableViewer.refresh();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		Menu menu = new Menu(parent);
		parent.setMenu(menu);
		
		MenuItem mntmAbout = new MenuItem(menu, SWT.NONE);
		mntmAbout.setText("About");

		//here add action listener or event handler
		
		MenuItem mntmNothing = new MenuItem(menu, SWT.NONE);
		mntmNothing.setText("Nothing");
		new Label(parent, SWT.NONE);
	}
	
	private void setLabels(Composite parent) {
		Label lblName = new Label(parent, SWT.NONE);
		lblName.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblName.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		lblName.setText("Biblioteka G\u0142\u00F3wna w Capgemini");
		
		Label lblSearchBookBy = new Label(parent, SWT.NONE);
		lblSearchBookBy.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSearchBookBy.setText("Search Book by Title: ");
	}
	
	@Override
	public void setFocus() {
		tableViewer.getControl().setFocus();
		
	}
}
