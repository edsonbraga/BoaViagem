package com.example.edsonbraga.boaviagem;

import android.os.Bundle;

import com.example.edsonbraga.boaviagem.domain.Anotacao;

public interface AnotacaoListener {
	void viagemSelecionada(Bundle bundle);
	void anotacaoSelecionada(Anotacao anotacao);
	void novaAnotacao();
}