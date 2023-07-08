package controller;

public enum IDJogador {
	_1_(1),
	_2_(2),
	_3_(3),
	_4_(4);
	
	private int id;

	IDJogador(int i) {
		setId(i);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
