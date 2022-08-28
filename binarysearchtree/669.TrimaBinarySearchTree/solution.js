// 迭代法
var trimBST = function(root, low, high) {
    if(root === null) {
        return null;
    }
    while(root !==null &&(root.val<low||root.val>high)) {
        if(root.val<low) {
            root = root.right;
        }else {
            root = root.left;
        }
    }
    let cur = root;
    while(cur!==null) {
        while(cur.left&&cur.left.val<low) {
            cur.left = cur.left.right;
        }
        cur = cur.left;
    }
    cur =  root;
    //判断右子树大于high的情况
    while(cur!==null) {
        while(cur.right&&cur.right.val>high) {
            cur.right = cur.right.left;
        }
        cur = cur.right;
    }
    return root;
 };