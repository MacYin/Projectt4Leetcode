package custom.code;

/**
 * @author wuyin
 * @date 2020/5/6 16:45
 */
public class SortDemo {
	/*
	 * 快速排序
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     left -- 数组的左边界(例如，从起始位置开始排序，则l=0)
	 *     right -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
	 */
	public static void quickSort( int a[], int left, int right ) {
		int i,j,temp;
//		if( left < right ) {
//			int i, j, temp;
//
//			i = left;
//			j = right;
//			temp = a[ i ];
//			while( i < j ) {
//				while( i < j && a[ j ] > temp ) {
//					j--; // 从右向左找第一个小于x的数
//				}
//				if( i < j ) {
//					a[ i++ ] = a[ j ];
//				}
//				while( i < j && a[ i ] < temp ) {
//					i++; // 从左向右找第一个大于x的数
//				}
//				if( i < j ) {
//					a[ j-- ] = a[ i ];
//				}
//			}
//			a[ i ] = temp;
//			quickSort( a, left, i - 1 ); /* 递归调用 */
//			quickSort( a, i + 1, right ); /* 递归调用 */
//		}
		if( left < right ){
			i = left;
			j = right;
			temp = a[i];
			while(i < j){
				while( i < j && temp < a[j] ){
					j--;
				}
				if( i < j ){
					a[i++] = a[j];
				}
				while( i < j && a[i] < temp){
					i++;
				}
				if( i < j ){
					a[j--] = a[i];
				}
			}
			a[i] = temp;
			quickSort( a, left, i - 1 );
			quickSort( a, i + 1, right );
		}
	}

	public static void insertSort(int a[]){
		int i, j;
		for (i = 1; i < a.length; i++) {
			/*
			 * 循环不变式：a[0...i-1]有序。每次迭代开始前，a[0...i-1]有序，
			 * 循环结束后i=n，a[0...n-1]有序
			 * */
			int key = a[i];
			for (j = i; j > 0 && a[j-1] > key; j--) {
				a[j] = a[j-1];
			}
			a[j] = key;
		}
	}


	public static void main( String[] args ) {
		int[] ints = new int[] {5, 4, 2, 3, 9, 8, 6, 1, 7};
//		quickSort( ints, 0, ints.length - 1 );
		insertSort( ints );
		for( int i : ints ) {
			System.out.print( i + " " );
		}
	}
}
