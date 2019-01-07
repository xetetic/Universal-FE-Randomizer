package random.snes.fe4.loader;

import java.util.HashMap;
import java.util.Map;

import fedata.snes.fe4.FE4ChildCharacter;
import fedata.snes.fe4.FE4Data;
import fedata.snes.fe4.FE4Data.EnemyTable;
import fedata.snes.fe4.FE4EnemyCharacter;
import fedata.snes.fe4.FE4StaticCharacter;
import io.FileHandler;
import util.DebugPrinter;

public class CharacterDataLoader {
	
	private Map<FE4Data.Character, FE4StaticCharacter> staticPlayableCharacters;
	private Map<FE4Data.Character, FE4ChildCharacter> childCharacters;
	
	private Map<FE4Data.Character, FE4EnemyCharacter> enemyCharacters;
	private Map<FE4Data.Character, FE4EnemyCharacter> arenaCharacters;
	private Map<FE4Data.Character, FE4EnemyCharacter> bossCharacters;
	
	private Map<FE4Data.Character, FE4StaticCharacter> holyBloodBossCharacters;
	
	private boolean isHeadered;
	
	public static final String RecordKeeperCategoryKey = "Characters";
	
	public CharacterDataLoader(FileHandler handler, boolean headered) {
		super();
		
		this.isHeadered = headered;
		
		initializeStaticPlayableCharacters(handler);
		
		initializeChildCharacters(handler);
		
		initializeEnemyAndArenaCharacters(handler);
		
		initializeHolyBossCharacters(handler);
	}
	
	private void initializeStaticPlayableCharacters(FileHandler handler) {
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loading Static Playable Characters...");
		
		staticPlayableCharacters = new HashMap<FE4Data.Character, FE4StaticCharacter>();
		
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loading Gen1 Playable Characters...");
		
		// Load Gen 1 PCs.
		for (int i = 0; i < FE4Data.Gen1CharacterCount; i++) {
			long dataOffset = FE4Data.Gen1CharacterTableOffset + (i * FE4Data.StaticCharacterSize);
			if (!isHeadered) {
				dataOffset -= 0x200; 
			}
			byte[] charData = handler.readBytesAtOffset(dataOffset, FE4Data.StaticCharacterSize);
			FE4StaticCharacter staticChar = new FE4StaticCharacter(charData, dataOffset);
			FE4Data.Character fe4Character = FE4Data.Character.valueOf(staticChar.getCharacterID());
			if (fe4Character != null) {
				staticPlayableCharacters.put(fe4Character, staticChar);
				DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded Character: " + fe4Character.toString());
			} else {
				System.err.println("Invalid character found in static playable characters. ID = 0x" + Integer.toHexString(staticChar.getCharacterID()));
			}
		}
		
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Finished Loading Gen1 Playable Characters!");
		
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loading Gen2 Playable Characters...");
		
		// Load Gen2 Statics.
		// Shanan, Dalvin, Asaello
		for (int i = 0; i < FE4Data.Gen2StaticCharacterTable1Count; i++) {
			long dataOffset = FE4Data.Gen2StaticCharacterTable1Offset + (i * FE4Data.StaticCharacterSize);
			if (!isHeadered) {
				dataOffset -= 0x200; 
			}
			byte[] charData = handler.readBytesAtOffset(dataOffset, FE4Data.StaticCharacterSize);
			FE4StaticCharacter staticChar = new FE4StaticCharacter(charData, dataOffset);
			FE4Data.Character fe4Character = FE4Data.Character.valueOf(staticChar.getCharacterID());
			if (fe4Character != null) {
				staticPlayableCharacters.put(fe4Character, staticChar);
				DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded Character: " + fe4Character.toString());
			} else {
				System.err.println("Invalid character found in static playable characters. ID = 0x" + Integer.toHexString(staticChar.getCharacterID()));
			}
		}
		
		// Iuchar, Charlot, Hawk, Tristan, Finn, Deimne, Hannibal, Ares, Amid, Oifey, Daisy, Creidne, Muirne, Julia
		for (int i = 0; i < FE4Data.Gen2StaticCharacterTable2Count; i++) {
			long dataOffset = FE4Data.Gen2StaticCharacterTable2Offset + (i * FE4Data.StaticCharacterSize);
			if (!isHeadered) {
				dataOffset -= 0x200; 
			}
			byte[] charData = handler.readBytesAtOffset(dataOffset, FE4Data.StaticCharacterSize);
			FE4StaticCharacter staticChar = new FE4StaticCharacter(charData, dataOffset);
			FE4Data.Character fe4Character = FE4Data.Character.valueOf(staticChar.getCharacterID());
			if (fe4Character != null) {
				staticPlayableCharacters.put(fe4Character, staticChar);
				DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded Character: " + fe4Character.toString());
			} else {
				System.err.println("Invalid character found in static playable characters. ID = 0x" + Integer.toHexString(staticChar.getCharacterID()));
			}
		}
		
		// Hermina, Linda, Laylea, Jeanne, Iucharba
		for (int i = 0; i < FE4Data.Gen2StaticCharacterTable3Count; i++) {
			long dataOffset = FE4Data.Gen2StaticCharacterTable3Offset + (i * FE4Data.StaticCharacterSize);
			if (!isHeadered) {
				dataOffset -= 0x200; 
			}
			byte[] charData = handler.readBytesAtOffset(dataOffset, FE4Data.StaticCharacterSize);
			FE4StaticCharacter staticChar = new FE4StaticCharacter(charData, dataOffset);
			FE4Data.Character fe4Character = FE4Data.Character.valueOf(staticChar.getCharacterID());
			if (fe4Character != null) {
				staticPlayableCharacters.put(fe4Character, staticChar);
				DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded Character: " + fe4Character.toString());
			} else {
				System.err.println("Invalid character found in static playable characters. ID = 0x" + Integer.toHexString(staticChar.getCharacterID()));
			}
		}
		
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Finished Loading Gen2 Playable Characters!");
		
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Finished loading Static Playable Characters!");
	}
	
	private void initializeChildCharacters(FileHandler handler) {
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loading Child Playable Characters...");
		
		childCharacters = new HashMap<FE4Data.Character, FE4ChildCharacter>();
		
		// Seliph and Leif
		for (int i = 0; i < FE4Data.Gen2ChildrenCharacterTable1Count; i++) {
			long dataOffset = FE4Data.Gen2ChildrenCharacterTable1Offset + (i * FE4Data.Gen2ChildrenCharacterTable1ItemSize);
			if (!isHeadered) {
				dataOffset -= 0x200;
			}
			byte[] charData = handler.readBytesAtOffset(dataOffset, FE4Data.Gen2ChildrenCharacterTable1ItemSize);
			FE4ChildCharacter child = new FE4ChildCharacter(charData, dataOffset);
			FE4Data.Character fe4Character = FE4Data.Character.valueOf(child.getCharacterID());
			if (fe4Character != null) {
				childCharacters.put(fe4Character, child);
				DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded Child: " + fe4Character.toString());
			} else {
				System.err.println("Invalid child found. ID = 0x" + Integer.toHexString(child.getCharacterID()));
			}
		}
		
		// Altena
		for (int i = 0; i < FE4Data.Gen2ChildrenCharacterTable2Count; i++) {
			long dataOffset = FE4Data.Gen2ChildrenCharacterTable2Offset + (i * FE4Data.Gen2ChildrenCharacterSize);
			if (!isHeadered) {
				dataOffset -= 0x200;
			}
			byte[] charData = handler.readBytesAtOffset(dataOffset, FE4Data.Gen2ChildrenCharacterSize);
			FE4ChildCharacter child = new FE4ChildCharacter(charData, dataOffset);
			FE4Data.Character fe4Character = FE4Data.Character.valueOf(child.getCharacterID());
			if (fe4Character != null) {
				childCharacters.put(fe4Character, child);
				DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded Child: " + fe4Character.toString());
			} else {
				System.err.println("Invalid child found. ID = 0x" + Integer.toHexString(child.getCharacterID()));
			}
		}
		
		// Every other child.
		for (int i = 0; i < FE4Data.Gen2ChildrenCharacterTable3Count; i++) {
			long dataOffset = FE4Data.Gen2ChildrenCharacterTable3Offset + (i * FE4Data.Gen2ChildrenCharacterSize);
			if (!isHeadered) {
				dataOffset -= 0x200;
			}
			byte[] charData = handler.readBytesAtOffset(dataOffset, FE4Data.Gen2ChildrenCharacterSize);
			FE4ChildCharacter child = new FE4ChildCharacter(charData, dataOffset);
			FE4Data.Character fe4Character = FE4Data.Character.valueOf(child.getCharacterID());
			if (fe4Character != null) {
				childCharacters.put(fe4Character, child);
				DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded Child: " + fe4Character.toString());
			} else {
				System.err.println("Invalid child found. ID = 0x" + Integer.toHexString(child.getCharacterID()));
			}
		}
		
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Finished loading Child Playable Characters!");
	}
	
	private void initializeEnemyAndArenaCharacters(FileHandler handler) {
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loading Minions and Arena Characters...");
		
		enemyCharacters = new HashMap<FE4Data.Character, FE4EnemyCharacter>();
		arenaCharacters = new HashMap<FE4Data.Character, FE4EnemyCharacter>();
		bossCharacters = new HashMap<FE4Data.Character, FE4EnemyCharacter>();
		
		for (EnemyTable table : EnemyTable.values()) {
			DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loading from " + table.toString());
			long baseOffset = table.offset;
			int count = table.count;
			for (int i = 0; i < count; i++) {
				long dataOffset = baseOffset + (i * FE4Data.EnemyDataSize);
				if (!isHeadered) {
					dataOffset -= 0x200;
				}
				byte[] charData = handler.readBytesAtOffset(dataOffset, FE4Data.EnemyDataSize);
				FE4EnemyCharacter enemy = new FE4EnemyCharacter(charData, dataOffset);
				FE4Data.Character fe4Character = FE4Data.Character.valueOf(enemy.getCharacterID());
				if (fe4Character != null) {
					if (fe4Character.isMinion()) {
						enemyCharacters.put(fe4Character, enemy);
						DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded " + fe4Character.toString() + " as minion.");
					} else if (fe4Character.isArena()) {
						arenaCharacters.put(fe4Character, enemy);
						DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded " + fe4Character.toString() + " as arena.");
					} else {
						bossCharacters.put(fe4Character, enemy);
						DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded " + fe4Character.toString() + " as boss.");
					}
				} else {
					System.err.println("Invalid enemy found. Dropping... (Enemy ID: 0x" + Integer.toHexString(enemy.getCharacterID()) + ")");
				}
			}
			DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Finished loading from " + table.toString());
		}
		
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Finished loading Minions and Arena Characters!");
	}
	
	private void initializeHolyBossCharacters(FileHandler handler) {
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loading Bosses with Holy Blood...");
		
		holyBloodBossCharacters = new HashMap<FE4Data.Character, FE4StaticCharacter>();
		
		for (FE4Data.HolyEnemyTable table : FE4Data.HolyEnemyTable.values()) {
			DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loading from " + table.toString());
			long baseOffset = table.offset;
			int count = table.count;
			for (int i = 0; i < count; i++) {
				long dataOffset = baseOffset + (i * FE4Data.StaticCharacterSize);
				if (!isHeadered) {
					dataOffset -= 0x200;
				}
				byte[] charData = handler.readBytesAtOffset(dataOffset, FE4Data.StaticCharacterSize);
				FE4StaticCharacter holyChar = new FE4StaticCharacter(charData, dataOffset);
				FE4Data.Character fe4Character = FE4Data.Character.valueOf(holyChar.getCharacterID());
				if (fe4Character != null) {
					holyBloodBossCharacters.put(fe4Character, holyChar);
					DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Loaded " + fe4Character.toString() + " as a holy character.");
				} else {
					System.err.println("Invalid holy character found. ID = 0x" + Integer.toHexString(holyChar.getCharacterID()));
				}
			}
			DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Finished loading from " + table.toString());
		}
		
		DebugPrinter.log(DebugPrinter.Key.FE4_CHARACTER_LOADER, "Finished loading bosses with holy blood!");
	}

}