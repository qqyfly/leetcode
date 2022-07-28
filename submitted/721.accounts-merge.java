import java.util.HashMap;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */
/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Example 2:

Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 

Constraints:

1 <= accounts.length <= 1000
2 <= accounts[i].length <= 10
1 <= accounts[i][j].length <= 30
accounts[i][0] consists of English letters.
accounts[i][j] (for j > 0) is a valid email.
 */
// @lc code=start
class Solution {
    
    //Method: Union Find

    // 50/50 cases passed (43 ms)
    // Your runtime beats 77.95 % of java submissions
    // Your memory usage beats 41.64 % of java submissions (66 MB)
    
    //思路：    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        //email 以及email的索引 对应表
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        
        //email和名字对应表
        Map<String, String> emailToName = new HashMap<String, String>();
        
        //索引-email对应表
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        
        int emailsCount = 0;

        for (List<String> account : accounts) {
            //获取名字
            String name = account.get(0);

            int size = account.size();

            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                //每次出现一个新的email,则更新email - index表
                if (!emailToIndex.containsKey(email)) {
                    
                    emailToIndex.put(email, emailsCount++);
                    //更新email和名字对应表
                    emailToName.put(email, name);
                }
            }
        }
        
        UnionFind uf = new UnionFind(emailsCount);

        //合并原始提供的账号中的email为一个账号
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);

            int firstIndex = emailToIndex.get(firstEmail);

            int size = account.size();

            for (int i = 2; i < size; i++) {

                String nextEmail = account.get(i);

                int nextIndex = emailToIndex.get(nextEmail);

                uf.union(firstIndex, nextIndex);
            }
        }
        
        //新建根节点 以及相关子节点 对应关系
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }

        //按序输出
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        
        return merged;
    }

    class UnionFind{
        int[] parent;

        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0;i < n;i++){
                parent[i] = i;
            }
        }

        public void union(int index1,int index2) {
            parent[find(index2)] = find(index1);
        }
        
        public int find(int index){
            if (parent[index] != index){
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }
}
// @lc code=end