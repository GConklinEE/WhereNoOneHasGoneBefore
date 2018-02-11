package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;

public class SimulationResults extends ModelCollection2Levels<DeltaVMapSegmentGroup> implements Serializable{

	// Constructors
	
	public SimulationResults(String name) {
		super(name);
	}
	
	// Methods 
	
	public String getDeltaVMapSegmentNameByIndex(int groupIndex, int segmentIndex) {
		return m_oModelCollection.elementAt(groupIndex).getDeltaVMapSegmentNameByIndex(segmentIndex);
	}
	
	public double getDeltaVByIndex(int groupIndex, int segmentIndex, boolean outgoing, boolean aerobraking) {
		return m_oModelCollection.elementAt(groupIndex).getDeltaVByIndex(segmentIndex, outgoing, aerobraking);
	}
	
	public double getMaxPayloadByIndex(int groupIndex, int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(groupIndex).getMaxPayloadByIndex(segmentIndex, outgoing);
	}
	
	public double getGroundLevelISPCorrectionFactorByIndex(int groupIndex, int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(groupIndex).getGroundLevelISPCorrectionFactorByIndex(segmentIndex, outgoing);
	}
		
	public double getDeltaVToVacuumISPValidByIndex(int groupIndex, int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(groupIndex).getDeltaVToVacuumISPValidByIndex(segmentIndex, outgoing);
	}
	
	public int getNumModelsByIndex(int groupIndex) {
		return m_oModelCollection.elementAt(groupIndex).getNumModels();
	}
		
	public void setMaxPayloadByIndex(int groupIndex, int segmentIndex, double maxPayload, boolean outgoing) {
		m_oModelCollection.elementAt(groupIndex).setMaxPayloadByIndex(segmentIndex, maxPayload, outgoing);
	}
		
	protected void performTasks() {};
	
	// Data members
	
	private static final long serialVersionUID = 1L; 
}
