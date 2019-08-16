__author__ = "lfs"
from collections import deque

class BST:
    class _Node:
        def __init__(self, e):
            self.e = e
            self.left = None
            self.right = None

    def __init__(self):
        self._root = None
        self._size = 0

    def size(self):
        return self._size

    def is_empty(self):
        return self._size == 0

    def _add(self, node, e):
        if not node:
            self._size += 1
            return self._Node(e)
        if node.e == e:
            return node
        elif node.e > e:
            node.left = self._add(node.left, e)
        else:
            node.right = self._add(node.right, e)
        return node

    def add(self, e):
        self._root = self._add(self._root, e)

    def _contains(self,node, e):
        if not node:
            return False
        if node.e == e:
            return True
        elif node.e > e:
            return self._contains(node.left, e)
        else:
            return self._contains(node.right, e)

    def contains(self, e):
        return self._contains(self._root, e)

    #前序遍历
    def _pre_order(self, node):
        if not node:
            return
        print(node.e)
        self._pre_order(node.left)
        self._pre_order(node.right)

    def pre_order(self):
        self._pre_order(self._root)

    def pre_order_NR(self):
        stack = []
        stack.append(self._root)
        while stack:
            curr = stack.pop()
            print(curr.e)
            if curr.right:
                stack.append(curr.right)
            if curr.left:
                stack.append(curr.left)

    def _in_order(self, node):
        if not node:
            return
        self._in_order(node.left)
        print(node.e)
        self._in_order(node.right)

    def in_order(self):
        self._in_order(self._root)

    def _post_order(self, node):
        if not node:
            return
        self._post_order(node.left)
        self._post_order(node.right)
        print(node.e)

    def post_order(self):
        self._post_order(self._root)

    def level_order(self):
        queue = deque()
        queue.append(self._root)
        while queue:
            curr = queue.popleft()
            print(curr.e)
            if curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)

    def _minimum(self, node):
        if not node.left:
            return node
        return self._minimum(node.left)

    def minimum(self):
        if self.is_empty():
            raise ValueError('BST is empty')
        return self._minimum(self._root)

    def _maximum(self, node):
        if not node.right:
            return node
        return self._maximum(node.right)
    def maximum(self):
        if self.is_empty():
            raise ValueError('BST is empty!')
        self._maximum(self._root)

    def _remove_min(self, node):
        if not node.left:
            right_node = node.right
            node.right = None
            self._size -= 1
            return right_node
        node.left = self._remove_min(node.left)
        return node

    def remove_min(self):
        ret = self.minimum()
        self._root = self._remove_min(self._root)
        return ret

    def _remove_max(self, node):
        if not node.right:
            left_node = node.left
            node.left = None
            self._size -= 1
            return left_node
        node.right = self._remove_max(node.right)
        return node

    def remove_max(self):
        ret = self.maximum()
        self._root = self._remove_max(self._root)
        return ret

    def _remove(self, node, e):
        if not node:
            return
        if node.e > e:
            node.left = self._remove(node.left, e)
            return node
        elif node.e < e:
            node.right = self._remove(node.right, e)
        else:
            if not node.left:
                right_node = node.right
                node.right = None
                self._size -= 1
                return right_node
            if not node.right:
                left_node = node.left
                node.left = None
                self._size -= 1
                return left_node
                # 如果左右子树均不为空
                # 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
                # 用这个节点顶替待删除节点的位置
            successor = self._minimum(node.right)
            successor.right = self._remove_min(node.right)
            successor.left = node.left
            node.left = node.right = None
            return successor

    def remove(self, e):
        self._root = self._remove(self._root, e)

    def _generate_depth_string(self, depth):
        res = ''
        for i in range(depth):
            res += '--'
        return res

    def _generate_BST_string(self, node, depth, res):
        if not node:
            res.append(self._generate_depth_string(depth) + 'None\n')
            return
        res.append(self._generate_depth_string(depth) + str(node.e) + '\n')
        self._generate_BST_string(node.left, depth + 1, res)
        self._generate_BST_string(node.right, depth + 1, res)

    def __str__(self):
        res = []
        self._generate_BST_string(self._root, 0, res)
        return '<chapter_06_BST.bst.BST>:\n' + ''.join(res)

    def __repr__(self):
        return self.__str__()

if __name__ == '__main__':
    bst = BST()
    # nums = [5, 3, 6, 8, 4, 2, 2]
    # for num in nums:
    #     bst.add(num)
    # bst.pre_order()
    # print(bst)

    # bst.in_order()
    # bst.post_order()
    # bst.pre_order_NR()
    # bst.level_order()

    from random import randint
    for i in range(20):
        bst.add(randint(0, 10))
    print(bst)
    bst.in_order()
    print('*' * 20)
    bst.remove_min()
    bst.remove_max()
    bst.in_order()
    print('*' * 20)
    print(bst.size())
