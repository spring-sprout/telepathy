package chapter8.matrixPath;

/**
 * 
 * @author donghun kim
 *
 */
public interface MatrixPath {
	/**
	 * 
	 * @param dataA   데이터용 2차원 배열
	 * @param resultA 결과저장용 2차원 배열
	 * @param row     결과요청 row    
	 * @param col     결과요청 col
	 * @return 최종 결과값
	 */
	public int matrixPath(int[][] dataA, int[][] resultA, int row, int col);
}
