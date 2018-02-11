package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;

public class DeltaVMapSegmentGroup extends ModelCollection<DeltaVMapSegment> implements Serializable, ICloneable<DeltaVMapSegmentGroup> {

	// Constructors
	
	public DeltaVMapSegmentGroup(String name) {
		super(name);
	}
	
	// Methods 
		
	public DeltaVMapSegmentGroup cloneObject() {
		DeltaVMapSegmentGroup deltaVMapSegmentGroup = new DeltaVMapSegmentGroup(m_sName);
		deltaVMapSegmentGroup.setModelCollection(m_oModelCollection);
		return deltaVMapSegmentGroup;
	}
			
	public String getDeltaVMapSegmentNameByIndex(int segmentIndex) {
		return m_oModelCollection.elementAt(segmentIndex).getName();
	}
	
	public double getDeltaVByIndex(int segmentIndex, boolean outgoing, boolean aerobraking) {
		return m_oModelCollection.elementAt(segmentIndex).getDeltaV(outgoing, aerobraking);
	}
	
	public double getMaxPayloadByIndex(int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(segmentIndex).getMaxPayload(outgoing);
	}
	
	public double getGroundLevelISPCorrectionFactorByIndex(int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(segmentIndex).getGroundLevelISPCorrectionFactor(outgoing);
	}
	
	public double getDeltaVToVacuumISPValidByIndex(int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(segmentIndex).getDeltaVToVacuumISPValid(outgoing);
	}
		
	public void setMaxPayloadByIndex(int segmentIndex, double maxPayload, boolean outgoing) {
		m_oModelCollection.elementAt(segmentIndex).setMaxPayload(maxPayload, outgoing);
	}
	
	protected void performTasks() {};
					
	// Data members
	
	private static final long serialVersionUID = 1L; 
}
