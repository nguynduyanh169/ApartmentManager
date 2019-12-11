package com.manager.dto;

public class BlockDTO {

	private long blockId;
	private String blockName;

	
	public BlockDTO(long blockId, String blockName) {
		super();
		this.blockId = blockId;
		this.blockName = blockName;
	}

	public long getBlockId() {
		return blockId;
	}

	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

}
