package com.hit.lab4;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class Solution6Test {
    
    @Test
    public void testPeopleIndexesBasic() {
        Solution6 solution = new Solution6();
        
        // 测试用例1：正常情况
        List<List<String>> favoriteCompanies1 = new ArrayList<>();
        favoriteCompanies1.add(Arrays.asList("google", "facebook"));
        favoriteCompanies1.add(Arrays.asList("google"));
        favoriteCompanies1.add(Arrays.asList("facebook", "amazon"));
        
        List<Integer> result1 = solution.peopleIndexes(favoriteCompanies1);
        List<Integer> expected1 = Arrays.asList(0, 2); // 索引0和2不是任何人的子集
        assertEquals("测试用例1失败", expected1, result1);
    }
    
    @Test
    public void testPeopleIndexesAllSubsets() {
        Solution6 solution = new Solution6();
        
        // 测试用例2：所有人都是其他人的子集
        List<List<String>> favoriteCompanies2 = new ArrayList<>();
        favoriteCompanies2.add(Arrays.asList("google", "facebook", "amazon"));
        favoriteCompanies2.add(Arrays.asList("google", "facebook"));
        favoriteCompanies2.add(Arrays.asList("google"));
        
        List<Integer> result2 = solution.peopleIndexes(favoriteCompanies2);
        List<Integer> expected2 = Arrays.asList(0); // 只有索引0（最大集合）不是子集
        assertEquals("测试用例2失败", expected2, result2);
    }
    
    @Test
    public void testPeopleIndexesNoSubsets() {
        Solution6 solution = new Solution6();
        
        // 测试用例3：没有子集关系
        List<List<String>> favoriteCompanies3 = new ArrayList<>();
        favoriteCompanies3.add(Arrays.asList("google"));
        favoriteCompanies3.add(Arrays.asList("facebook"));
        favoriteCompanies3.add(Arrays.asList("amazon"));
        
        List<Integer> result3 = solution.peopleIndexes(favoriteCompanies3);
        List<Integer> expected3 = Arrays.asList(0, 1, 2); // 所有人都不是子集
        assertEquals("测试用例3失败", expected3, result3);
    }
    
    @Test
    public void testPeopleIndexesEmpty() {
        Solution6 solution = new Solution6();
        
        // 测试用例4：空列表
        List<List<String>> favoriteCompanies4 = new ArrayList<>();
        
        List<Integer> result4 = solution.peopleIndexes(favoriteCompanies4);
        List<Integer> expected4 = new ArrayList<>(); // 空结果
        assertEquals("测试用例4失败", expected4, result4);
    }
    
    @Test
    public void testPeopleIndexesSingle() {
        Solution6 solution = new Solution6();
        
        // 测试用例5：只有一个用户
        List<List<String>> favoriteCompanies5 = new ArrayList<>();
        favoriteCompanies5.add(Arrays.asList("google", "facebook"));
        
        List<Integer> result5 = solution.peopleIndexes(favoriteCompanies5);
        List<Integer> expected5 = Arrays.asList(0); // 唯一的用户
        assertEquals("测试用例5失败", expected5, result5);
    }
    
    @Test
    public void testCheckMethod() {
        Solution6 solution = new Solution6();
        
        // 准备测试数据
        List<List<String>> data = new ArrayList<>();
        data.add(Arrays.asList("google", "facebook"));
        data.add(Arrays.asList("google", "facebook", "amazon"));
        
        // 先调用peopleIndexes初始化数组
        solution.peopleIndexes(data);
        
        // 测试check方法：索引0应该是索引1的子集
        assertTrue("check方法测试失败，应该是子集", solution.check(0, 1));
        assertFalse("check方法测试失败，应该不是子集", solution.check(1, 0));
    }
   }