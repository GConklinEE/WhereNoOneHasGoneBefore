package whereNoOneHasGoneBefore.Models;

import java.util.Vector;

public abstract class ModelCollection<T> {
	
	// Constructors
	
	public ModelCollection(String name) {
		m_sName = name;
		m_oModelCollection = new Vector<T>(); 
	}
	
	// Methods
		
	public void clearModels() {
		m_oModelCollection = new Vector<T>();
	}
	
	public void setModelCollection(Vector<T> models) {
		m_oModelCollection = new Vector<T>(models); 
	}
	
	public void addModel(T model) {
		addModel(m_oModelCollection.size(), model);
	}
	
	public void addModel(int index, T model) {
		m_oModelCollection.add(index, model);
	}
	
	public void replaceModel(int index, T model) {
		m_oModelCollection.set(index, model);
	}
	
	public void deleteModel(int index) {
		m_oModelCollection.removeElementAt(index);
	}	
		
	public String getName() {
		return m_sName;
	}
		
	public int getNumModels() {
		return m_oModelCollection.size();
	}
	
	public void setName(String name) {
		m_sName = name;
	}		

	// Data members
	
	protected String m_sName;
	protected Vector<T> m_oModelCollection; 
}
