package fedata.gcnwii.fe9.scripting;

import java.util.Arrays;

import io.gcn.GCNCMBFileHandler;

public class CallSceneByNameInstruction extends ScriptInstruction {

	String sceneName;
	int numberOfArgs;
	
	GCNCMBFileHandler handler;
	
	public CallSceneByNameInstruction(byte[] args, GCNCMBFileHandler handler) {
		sceneName = handler.stringForOffset(Arrays.copyOf(args, 2));
		numberOfArgs = args[2];
		this.handler = handler;
	}
	
	public CallSceneByNameInstruction(String sceneName, int numberOfArgs, GCNCMBFileHandler handler) {
		this.sceneName = sceneName;
		this.numberOfArgs = numberOfArgs;
		this.handler = handler;
	}
	
	@Override
	public String displayString() {
		return "CALL_SCENE_NAME (\"" + sceneName + "\", " + numberOfArgs + ")";
	}

	@Override
	public byte[] rawBytes() {
		byte[] referenceToString = handler.referenceToString(sceneName);
		if (referenceToString == null) { 
			handler.addString(sceneName);
			referenceToString = handler.referenceToString(sceneName);
		}
		assert(referenceToString != null);
		assert(referenceToString.length == 2);
		return new byte[] {0x38, (byte)((referenceToString[0] & 0xFF00) >> 8), (byte)(referenceToString[1] & 0xFF), (byte)(numberOfArgs & 0xFF)};
	}

	@Override
	public byte opcode() {
		return 0x38;
	}

	@Override
	public int numArgBytes() {
		return 3;
	}

	@Override
	public ScriptInstruction createWithArgs(byte[] args, GCNCMBFileHandler handler) {
		return new CallSceneByNameInstruction(args, handler);
	}

}
