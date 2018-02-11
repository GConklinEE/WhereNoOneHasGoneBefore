package whereNoOneHasGoneBefore.Models;

import java.util.Iterator;
import java.util.Vector;

public abstract class ModelCollection<T extends ICloneable<T>> implements IModelCollection<T>{
	
	// Constructors
	
	public ModelCollection(String name) {
		m_sName = name;
		m_oModelCollection = new Vector<T>(); 
	}
	
	// Methods
		
	public void clearModels() {
		m_oModelCollection = new Vector<T>();
		performTasks();
	}
	
	public void setModelCollection(Vector<T> modelsToClone) {
		m_oModelCollection = new Vector<T>(); 
		
		Iterator<T> oIterator = modelsToClone.iterator();
		while(oIterator.hasNext()) {
			m_oModelCollection.add(oIterator.next().cloneObject());
		}
		
		performTasks();
	}
	
	public void addModel(T model) {
		addModel(m_oModelCollection.size(), model);
	}
	
	public void addModel(int index, T model) {
		m_oModelCollection.add(index, model.cloneObject());
		performTasks();
	}
	
	public void replaceModel(int index, T model) {
		m_oModelCollection.set(index, model.cloneObject());
		performTasks();
	}
	
	public void deleteModel(int index) {
		m_oModelCollection.removeElementAt(index);
		performTasks();
	}	
		
	public String getName() {
		return m_sName;
	}
		
	public int getNumModels() {
		return m_oModelCollection.size();
	}
	
	public T getModelClone(int index) {
		return m_oModelCollection.elementAt(index).cloneObject();
	}
	
	public void setName(String name) {
		m_sName = name;
	}		

	protected abstract void performTasks();
	
	// Data members
	
	protected String m_sName;
	protected Vector<T> m_oModelCollection; 
}
