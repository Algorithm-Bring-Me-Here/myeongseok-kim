class Sol42842 {
    public int[] solution(int brown, int yellow) {
        int totalTiles = brown + yellow;

        for (int w = 3; w <= totalTiles; w++) {
            if (totalTiles % w == 0) {
                int h = totalTiles / w;
                if ((w - 2) * (h - 2) == yellow && 2 * w + 2 * h - 4 == brown) {
                    if (w >= h) {
                        return new int[] {w, h};
                    }
                }
            }
        }

        return new int[] {};
    }
}
