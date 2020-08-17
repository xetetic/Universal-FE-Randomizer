package fedata.gcnwii.fe9.scripting;

public class BitwiseXorInstruction extends ScriptInstruction {
	
	public BitwiseXorInstruction() {
		
	}

	@Override
	public String displayString() {
		return "BITWISE_XOR";
	}

	@Override
	public byte[] rawBytes() {
		return new byte[] {0x2C};
	}

	@Override
	public byte opcode() {
		return 0x2C;
	}

	@Override
	public int numArgBytes() {
		return 0;
	}

}
