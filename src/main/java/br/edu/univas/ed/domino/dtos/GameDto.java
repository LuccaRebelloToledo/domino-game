package br.edu.univas.ed.domino.dtos;

import br.edu.univas.ed.domino.models.Game;
import br.edu.univas.ed.domino.models.Player;

public record GameDto(Game game, Player currentPlayer) {}
