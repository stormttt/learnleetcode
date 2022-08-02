class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        # deque来自collections模块，不在力扣平台时，需要手动写入
        # 'from collections import deque' 导入
        # deque相比list的好处是，list的pop(0)是O(n)复杂度，deque的popleft()是O(1)复杂度

        quene = deque([root])
        out_list = []

        while quene:
            # 每次都取最后一个node就可以了
            node = quene[-1]
            out_list.append(node.val)

            # 执行这个遍历的目的是获取下一层所有的node
            for _ in range(len(quene)):
                node = quene.popleft()
                if node.left:
                    quene.append(node.left)
                if node.right:
                    quene.append(node.right)
        
        return out_list