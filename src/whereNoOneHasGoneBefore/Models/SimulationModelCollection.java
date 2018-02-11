package whereNoOneHasGoneBefore.Models;

import java.util.NoSuchElementException;

public abstract class SimulationModelCollection<T extends ICloneable<T> & IModelCollection2Levels<T>> extends ModelCollection3Levels<T> {
	
	// Constructors
	
	public SimulationModelCollection(String name) {
		super(name);
		performTasks();
	}
	
	// Methods
	
	public int getNumModelsLeft() {
		return m_oModelCollection.size() - m_iCurrentModel;
	}
	
	public boolean isActiveModel(int index) {
		if(index < 0 || index >= m_oModelCollection.size()) {
			throw new NoSuchElementException("SimulationModelCollection.isActiveModel: Tried to access a non-existent element!");
		}
		return index == m_iCurrentModel;
	}
	
	public boolean isCompletedModel(int index) {
		if(index < 0 || index >= m_oModelCollection.size()) {
			throw new NoSuchElementException("SimulationModelCollection.isCompletedModel: Tried to access a non-existent element!");
		}
		return index < m_iCurrentModel;
	}
	
	public void nextModel() { // We iterate through the models from 0 to max during a simulation 
		if (m_iCurrentModel == m_oModelCollection.size()) {
			throw new NoSuchElementException("SimulationModelCollection.nextModel: Tried to access a non-existent element!");
		} else {
			m_iCurrentModel++;
			calculateStats();
		}
	}
	
	public void resetSimulationToStart() {
		rewindSimulation(m_iCurrentModel);
	}
	
	public void rewindSimulation(int steps) {
		if(steps < 0) {
			throw new ArithmeticException("SimulationModelCollection.rewindSimulation: The number of steps to rewind the simulation by cannot be negative!");
		} else if(m_iCurrentModel < steps) {
			throw new NoSuchElementException("SimulationModelCollection.rewindSimulation: Cannot rewind the simulation further than where it started!");
		} else {
			if(steps != 0) {
				m_iCurrentModel -= steps;
				rewindStats(); 
				calculateStats(); 
			}
		}
	}
	
	protected void performTasks() {
		m_iCurrentModel = 0;
		calculateStats();
	};
	
	protected abstract void rewindStats();
	
	protected abstract void calculateStats();
	
	// Data members
	
	protected int m_iCurrentModel; 
}
