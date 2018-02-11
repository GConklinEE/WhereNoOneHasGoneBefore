package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;

public class DeltaVMapSegmentGroup extends ModelCollection<DeltaVMapSegment> implements Serializable {

	// Constructors
	
	public DeltaVMapSegmentGroup(String name) {
		super(name);
	}
	
	// Methods 
				
	public String getSegmentNameByIndex(int segmentIndex) {
		return m_oModelCollection.elementAt(segmentIndex).getName();
	}
	
	public double getSegmentGravityAtDestinationByIndex(int segmentIndex) {
		return m_oModelCollection.elementAt(segmentIndex).getGravityAtDestination();
	}
	
	public double getSegmentDeltaVByIndex(int segmentIndex, boolean outgoing, boolean aerobraking) {
		return m_oModelCollection.elementAt(segmentIndex).getDeltaV(outgoing, aerobraking);
	}
	
	public double getSegmentGroundLevelISPCorrectionFactorByIndex(int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(segmentIndex).getGroundLevelISPCorrectionFactor(outgoing);
	}
	
	public double getSegmentDeltaVToVacuumISPValidByIndex(int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(segmentIndex).getDeltaVToVacuumISPValid(outgoing);
	}
					
	// Data members
	
	private static final long serialVersionUID = 1L; 
}
