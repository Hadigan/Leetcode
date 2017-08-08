package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadigan on 2017/8/2.
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode resultHead = resultNode;
        resultNode.val = (l1.val + l2.val) % 10;
        int jinwei = (l1.val + l2.val) / 10;
        while(l1.next != null && l2.next != null) {
            resultNode.next = new ListNode(0);
            resultNode = resultNode.next;
            l1 = l1.next;
            l2 = l2.next;
            resultNode.val = (jinwei + l1.val + l2.val) % 10;
            jinwei = ( jinwei + l1.val + l2.val ) / 10;
        }
        if (l1.next == null && l2.next == null) {
            if (jinwei == 1){
                resultNode.next = new ListNode(1);
            }
        } else if (l1.next == null) {
                while(l2.next != null) {
                    if (jinwei == 0) {
                        resultNode.next = l2.next;
                        break;
                    }
                    resultNode.next = new ListNode(0);
                    resultNode = resultNode.next;
                    l2 = l2.next;
                    resultNode.val = (jinwei + l2.val) % 10;
                    jinwei = (jinwei + l2.val) / 10;
                }
            } else if (l2.next == null) {
                    while(l1.next != null) {
                        if (jinwei == 0) {
                            resultNode.next = l1.next;
                            break;
                        }
                        resultNode.next = new ListNode(0);
                        resultNode = resultNode.next;
                        l1 = l1.next;
                        resultNode.val = (jinwei + l1.val) % 10;
                        jinwei = (jinwei + l1.val) / 10;
                    }
                }
        if (jinwei == 1) {
            resultNode.next = new ListNode(jinwei);
        }
        return resultHead;

    }
    public String convert(String s, int numRows) {
        if (numRows<=1) return s;
        StringBuffer[] result = new StringBuffer[numRows];
        for (int i = 0;i < numRows;i++) {
            result[i] = new StringBuffer("");
        }
        int DownOrUp = -1;// 1:down -1:up
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            result[index].append(s.charAt(i));
            DownOrUp = (i % (numRows-1) == 0) ? -DownOrUp : DownOrUp;
            index = index + DownOrUp;
        }

        for (int i = 1; i < numRows; i++) {
            result[0].append(result[i]);
        }
        return result[0].toString();

    }
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int from = 0;
        int to = 0;
        if (s.length()<=1) {
            return s;
        }
        for (int i = 0; i<s.length(); i++) {
            int j =1;
            while((i-j>=0)&&(i+j<s.length())) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    if (j*2+1 > maxLength) {
                        maxLength = j * 2 + 1;
                        from = i - j;
                        to = i + j;
                    }
                    j++;
                    continue;
                }
                break;
            }
            j = 0;
            while((i - j >= 0) && (i + j + 1 < s.length())) {
                if (s.charAt(i-j) == s.charAt(i+j+1)) {
                    if (j * 2 + 2 > maxLength) {
                        maxLength = j * 2 + 2;
                        from = i - j;
                        to = i + j + 1;
                    }
                    j++;
                    continue;
                }
                break;
            }
        }
        return s.substring(from,to+1);
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    public void findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1=0;
        int start2=0;
        int end1 = nums1.length-1;
        int end2 = nums2.length-1;
        int medianPos1, medianPos2;
        double median1,median2;
        while(end1!=start1 && end2!=start2) {
            if ((start1+end1)%2==0 && (start2+end2)%2==0 ) {
                medianPos1 = (start1+end1)/2;
                medianPos2 = (start2+end2)/2;
                median1 = nums1[medianPos1];
                median2 = nums2[medianPos2];
                if (median1<median2) {
                    start1 = start1 + Math.min(medianPos1-start1,end2-medianPos2);
                    end2 = end2 - Math.min(medianPos1-start1,end2-medianPos2);
                }
                else {
                    start2 = start2;
                }
                continue;
            }
            if ((start1+end1)%2==0 && (start2+end2)%2!=0 ) {
                medianPos1 = (start1+end1)/2;
                medianPos2 = (start2+end2)/2;
                median1 = nums1[medianPos1];
                median2 = (nums2[medianPos2] + nums2[medianPos2+1])/2;
            }
            else {
                median1 = (nums1[(start1+end1)/2] + nums1[(start1+end1)/2+1]);
            }

            medianPos1 = (start1 + end1)/2;
            medianPos2 = (start2+end2)/2;

        }
    }
}
