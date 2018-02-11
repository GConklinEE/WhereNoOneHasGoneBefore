package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;

public class DeltaVMap extends ModelCollection<DeltaVMapSegmentGroup> implements Serializable {
	
	// Constructors
	
	public DeltaVMap(String name) {
		super(name);
	}
	
	// Methods 
	
	public boolean checkDataIntegrity() {

		// Checks that all group names are unique
		for(int SegmentGroupIndex1 = 0; SegmentGroupIndex1 < m_oModelCollection.size(); SegmentGroupIndex1++) {
			for(int SegmentGroupIndex2 = SegmentGroupIndex1 + 1; SegmentGroupIndex2 < m_oModelCollection.size(); SegmentGroupIndex2++) {
				if(m_oModelCollection.elementAt(SegmentGroupIndex1).getName() == m_oModelCollection.elementAt(SegmentGroupIndex2).getName()) {
					return false;
				}
			}
		}
		
		// Checks that all destination names are unique
		for(int SegmentGroupIndex1 = 0; SegmentGroupIndex1 < m_oModelCollection.size(); SegmentGroupIndex1++) {
			for(int SegmentIndex1 = 0; SegmentIndex1 < m_oModelCollection.elementAt(SegmentGroupIndex1).getNumModels(); SegmentIndex1++) {
				for(int SegmentGroupIndex2 = SegmentGroupIndex1; SegmentGroupIndex2 < m_oModelCollection.size(); SegmentGroupIndex2++) {
					for(int SegmentIndex2 = SegmentIndex1 + 1; SegmentIndex2 < m_oModelCollection.elementAt(SegmentGroupIndex2).getNumModels(); SegmentIndex2++) {
						if(m_oModelCollection.elementAt(SegmentGroupIndex1).getSegmentNameByIndex(SegmentIndex1) == 
						   m_oModelCollection.elementAt(SegmentGroupIndex2).getSegmentNameByIndex(SegmentIndex2)) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
		
	public String getSegmentGroupNameByIndex(int segmentGroupIndex) {
		return m_oModelCollection.elementAt(segmentGroupIndex).getName();
	}
	
	public String getSegmentNameByIndex(int segmentGroupIndex, int segmentIndex) {
		return m_oModelCollection.elementAt(segmentGroupIndex).getSegmentNameByIndex(segmentIndex);
	}
	
	public double getSegmentGravityAtDestinationByIndex(int segmentGroupIndex, int segmentIndex) {
		return m_oModelCollection.elementAt(segmentGroupIndex).getSegmentGravityAtDestinationByIndex(segmentIndex);
	}
	
	public double getSegmentDeltaVByIndex(int segmentGroupIndex, int segmentIndex, boolean outgoing, boolean aerobraking) {
		return m_oModelCollection.elementAt(segmentGroupIndex).getSegmentDeltaVByIndex(segmentIndex, outgoing, aerobraking);
	}
	
	public double getSegmentGroundLevelISPCorrectionFactorByIndex(int segmentGroupIndex, int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(segmentGroupIndex).getSegmentGroundLevelISPCorrectionFactorByIndex(segmentIndex, outgoing);
	}
	
	public double getSegmentDeltaVToVacuumISPValidByIndex(int segmentGroupIndex, int segmentIndex, boolean outgoing) {
		return m_oModelCollection.elementAt(segmentGroupIndex).getSegmentDeltaVToVacuumISPValidByIndex(segmentIndex, outgoing);
	}
		
	public int getNumSegmentModelsByIndex(int segmentGroupIndex) {
		return m_oModelCollection.elementAt(segmentGroupIndex).getNumModels();
	}
		
	// Data members
	
	private static final long serialVersionUID = 1L; 
}
