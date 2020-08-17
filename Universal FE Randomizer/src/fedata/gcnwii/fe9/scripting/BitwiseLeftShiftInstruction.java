package fedata.gcnwii.fe9.scripting;

public class BitwiseLeftShiftInstruction extends ScriptInstruction {

	public BitwiseLeftShiftInstruction() {
		
	}
	
	@Override
	public String displayString() {
		return "BITWISE_LEFT_SHIFT";
	}

	@Override
	public byte[] rawBytes() {
		return new byte[] {0x2D};
	}

	@Override
	public byte opcode() {
		return 0x2D;
	}

	@Override
	public int numArgBytes() {
		return 0;
	}
}
