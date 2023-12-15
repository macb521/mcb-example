package com.example.test.tree;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/12/6
 */
public class TreeTest {

    public static void main(String[] args) {
        List<TreeNode<Long>> treeNode = Lists.newArrayList();
        List<Tree<Long>> build = TreeUtil.build(treeNode, 0L);
    }
}
