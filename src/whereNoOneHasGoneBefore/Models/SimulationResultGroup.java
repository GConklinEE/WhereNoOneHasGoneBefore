package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;

public class SimulationResultGroup extends ModelCollection<SimulationResult> implements Serializable{

	// Constructors
	
	public SimulationResultGroup(String name) {
		super(name);
	}
	
	// Methods 
	
	public String getDestinationNameByIndex(int modelIndex) {
		return m_oModelCollection.elementAt(modelIndex).getDestinationName();
	}
	
	public double getMaxPayloadByIndex(int modelIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(modelIndex).getMaxPayload(outgoing);
	}
				
	public void setMaxPayloadByIndex(int modelIndex, double maxPayload, boolean outgoing) {
		m_oModelCollection.elementAt(modelIndex).setMaxPayload(maxPayload, outgoing);
	}
	
	// Data members
	
	private static final long serialVersionUID = 1L; 
}
