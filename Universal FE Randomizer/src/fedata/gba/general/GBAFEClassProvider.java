package fedata.gba.general;

import java.util.Map;
import java.util.Set;

import fedata.gba.GBAFEClassData;

public interface GBAFEClassProvider {
	public static final String optionKeyExcludeSource = "excludeSource";
	public static final String optionKeyExcludeLords = "excludeLords";
	public static final String optionKeyExcludeThieves = "excludeThieves";
	public static final String optionKeySeparateMonsters = "separateMonsters"; // FE8 only.
	public static final String optionKeyRequireAttack = "requireAttack";
	public static final String optionKeyRequireRange = "requireRange";
	public static final String optionKeyRequireMelee = "requireMelee";
	public static final String optionKeyApplyRestrictions = "applyRestrictions";
	
	public long classDataTablePointer();
	public int numberOfClasses();
	public int bytesPerClass();
	
	public GBAFEClass[] allClasses();
	
	public Set<GBAFEClass> allValidClasses();
	public Set<GBAFEClass> meleeSupportedClasses();
	public Set<GBAFEClass> rangeSupportedClasses();
	
	public GBAFEClass classWithID(int classID);
	
	public boolean canClassDemote(GBAFEClass charClass);
	public boolean canClassPromote(GBAFEClass charClass);
	
	public GBAFEClass[] promotedClass(GBAFEClass baseClass);
	public GBAFEClass[] demotedClass(GBAFEClass promotedClass);
	
	public boolean isFlier(GBAFEClass charClass);
	
	public Set<GBAFEClass> classesThatLoseToClass(GBAFEClass sourceClass, GBAFEClass winningClass, Map<String, Boolean> options);
	public Set<GBAFEClass> targetClassesForRandomization(GBAFEClass sourceClass, Map<String, Boolean> options);
	
	public void prepareForClassRandomization(Map<Integer, GBAFEClassData> classMap);
	
	public GBAFEClassData classDataWithData(byte[] data, long offset);
}
