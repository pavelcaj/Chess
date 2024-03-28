package org.example.piece;

import com.google.common.collect.ImmutableList;

import org.example.board.Board;
import org.example.board.Move;
import org.example.board.Tile;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    private final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};
    Knight(int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }


    @Override
    public List<Move> calculateLegalMoves(Board board) {
        int candidateDestinalCoordinate;
        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentCandidate : CANDIDATE_MOVE_COORDINATES) {
            candidateDestinalCoordinate = this.piecePosition + currentCandidate;

            if (true) {

                final Tile candidateDestionlTile = board.getTile(candidateDestinalCoordinate);

                if (!candidateDestionlTile.isTileOccupied()) {
                    legalMoves.add(new Move());

                } else {

                    final Piece pieceAtDestination = candidateDestionlTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                    if (this.pieceAlliance != pieceAlliance) {
                        legalMoves.add(new Move());
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
}
