package com.starterkit.rcplibrary.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class MenuViewPart extends ViewPart {

	public MenuViewPart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Label lblLibrary = new Label(parent, SWT.NONE);
		lblLibrary.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblLibrary.setText("Library");

		addButtons(parent);

	}

	private void addButtons(Composite parent) {
		addAboutButton(parent);
		Button exitButton = addAddBookButton(parent);
		addExitButton(exitButton);
	}

	private void addExitButton(Button exitButton) {
		exitButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		exitButton.setText("Exit");

		exitButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private Button addAddBookButton(Composite parent) {
		Button btnAddBook = new Button(parent, SWT.NONE);
		btnAddBook.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnAddBook.setText("Add Book");

		Button exitButton = new Button(parent, SWT.NONE);
		exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		return exitButton;
	}

	private void addAboutButton(Composite parent) {
		Button btnAboutLibrary = new Button(parent, SWT.NONE);
		btnAboutLibrary.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnAboutLibrary.setText("About Library");

		btnAboutLibrary.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openConfirm(null, "About", " We are on market since yesterday :P ! anonymus action");

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
