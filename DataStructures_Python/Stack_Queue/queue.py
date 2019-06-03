__author__ = "lfs"
import sys,os
path = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
sys.path.insert(0, path)
from base import QueueBase
from Arrays.array import Array
class ArrayQueue(QueueBase):
    def __init__(self, capacity=0):
        self._array = Array(capacity)
    def get_size(self):
        return self._array.get_size()
    def is_empty(self):
        return self._array.is_empty()

    def get_capacity(self):
        return self.get_capacity()

    def enqueue(self, e):
        self._array.add_last(e)

    def dequeue(self):
        return self._array.remove_first()

    def get_front(self):
        return self._array.get_first()

    def __str__(self):
        return str('<chapter_03_Stack_Queue.queue.ArrayQueue> : {}'.format(self._array))

    def __repr__(self):
        return self.__str__()