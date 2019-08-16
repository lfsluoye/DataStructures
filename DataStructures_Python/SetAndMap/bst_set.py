__author__ = "lfs"
from bst import BST
from base import SetBase

class BSTSet(SetBase):
    def __init__(self):
        self._bst = BST()

    def get_size(self):
        return self._bst.size()

    def is_empty(self):
        return self._bst.is_empty()

    def add(self, e):
        return self._bst.add(e)

    def contains(self, e):
        return self._bst.contains(e)

    def remove(self, e):
        return self._bst.remove(e)

