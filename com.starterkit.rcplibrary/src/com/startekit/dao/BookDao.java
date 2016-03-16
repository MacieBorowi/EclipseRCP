package com.startekit.dao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BookDao {

	private Long id;
	private String title;
	private String autor;
	private String subject;
	private String description;
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public BookDao() {
	}

	public BookDao(long id, String title, String autor, String subject, String description) {
		this.id = id;
		this.title = title;
		this.autor = autor;
		this.subject = subject;
		this.description = description;

	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		propertyChangeSupport.firePropertyChange("subject", this.subject,
		        this.subject = subject);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDao other = (BookDao) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookDao [id=" + id + ", title=" + title + ", autor=" + autor + ", subject=" + subject + ", description="
				+ description + ", propertyChangeSupport=" + propertyChangeSupport + "]";
	}

	
}
