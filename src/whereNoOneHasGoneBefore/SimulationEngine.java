package whereNoOneHasGoneBefore;

public class SimulationEngine {
	// As it stands now, the simulation engine will need to check the stage groups to ensure they have one, and only one, main stage defined; even if exceptions are thrown, they can still get messed up. 
	// Would be better if the stage groups themselves enforced this by refusing to add/delete stages that violate constraints. Since these add/delete methods are currently in generic model collection classes, this can't be easily done. 
	
	// The collections have generic methods that really need wrappers or some way to identify what they actually do. Nobody knows the internal structure of the rocket object, so methods like 'replaceLevel2ModelByIndex' are meaningless.
	
	// The generics in the second and third level collections aren't right.
	// Might want to add something to model fairings... although those add only a little mass on the first stage ascent, so not a huge amount of difference. Probably not worth it.
}