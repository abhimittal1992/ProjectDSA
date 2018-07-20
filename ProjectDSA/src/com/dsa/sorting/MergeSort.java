package com.dsa.sorting;

public class MergeSort {
	public static void main(String[] args) {
		int a[] = { 12, 11, 13, 5, 6, 7 };
		sort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.println(i);
		}
	}

	static void merge(int a[], int low, int high, int middle) {

		int n1 = middle - low + 1;
		int n2 = high - middle;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = a[low + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = a[middle + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = low;

		while (i < n1 && j < n2) {
			if (L[i] < R[j]) {
				a[k] = L[i];
				i++;
				k++;

			} else {
				a[k] = R[j];
				j++;
				k++;
			}
		}

		while (i < n1) {

			a[k] = L[i];
			k++;
			i++;

		}
		while (j < n2) {
			a[k] = R[j];
			k++;
			j++;

		}

	}

	private static void sort(int[] a, int low, int high) {
		if (low < high) {
			int middle = (high + low) / 2;
			sort(a, low, middle);
			sort(a, middle + 1, high);
			merge(a, low, high, middle);
		}
	}

}
