package org.example.board;

import com.google.common.collect.ImmutableMap;
import org.example.piece.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
    protected final int tileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {


        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for (int i = 0; i < 64; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }
public static Tile crateTile(final int tileCoordinate, final Piece piece){
        return piece != null ?
                new OccupedTile(tileCoordinate, piece) :
                EMPTY_TILES_CACHE.get(tileCoordinate);
}
   private Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {
        EmptyTile(final int coordinate) {
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }

    }

    public static class OccupedTile extends Tile {
        private final Piece pieceOnTile;

        OccupedTile(int tileCoordinate, Piece pieceOnTile) {
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }

}