package org.example.piece;

import com.google.common.collect.ImmutableList;

import org.example.board.Board;
import org.example.logick.Logick;
import org.example.board.Move;
import org.example.board.Tile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.example.logick.Logick.isValidCoordinate;

public class Knight extends Piece {
    private final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

    Knight(int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }


    @Override
    public Collection<Move> calculateLegalMoves(Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
            final int candidateDestinalCoordinate = this.piecePosition + currentCandidateOffset;

            if (isValidCoordinate(candidateDestinalCoordinate)) {

                if (isFirstColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isSecondColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isSevenColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isEightColumnExlusion(this.piecePosition, currentCandidateOffset)) {
                    continue;
                }

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

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
        return Logick.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10 ||
                candidateOffset == 6 || candidateOffset == 15);
    }

    private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
        return Logick.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || candidateOffset == 6);
    }

    private static boolean isSevenColumnExclusion(final int currentPosition, final int candidateOffset) {
        return Logick.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
    }

    private static boolean isEightColumnExlusion(final int currentPosition, final int candidateOffset) {
        return Logick.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -15 || candidateOffset == -6 ||
                candidateOffset == 10 || candidateOffset == 17);
    }
}
