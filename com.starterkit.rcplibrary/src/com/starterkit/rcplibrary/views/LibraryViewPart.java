package com.starterkit.rcplibrary.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class LibraryViewPart extends ViewPart {

	private Text text;
	private Table table;
	
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
		TableViewer tableViewer = new TableViewer(parent,SWT.MULTI | SWT.H_SCROLL
			      | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setLinesVisible(true);
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
		new Label(parent, SWT.NONE);
		
		Menu menu = new Menu(parent);
		parent.setMenu(menu);
		
		MenuItem mntmAbout = new MenuItem(menu, SWT.NONE);
		mntmAbout.setText("About");
		
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
		// TODO Auto-generated method stub
		
	}
}
