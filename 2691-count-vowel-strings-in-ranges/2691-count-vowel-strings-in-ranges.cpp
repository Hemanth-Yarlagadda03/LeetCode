class Solution {
public:
    vector<int> vowelStrings(vector<string>& words,
                           vector<vector<int>>& queries) {
    vector<int> ans;
    vector<int> psum(words.size() + 1);

    for (int i = 0; i < words.size(); ++i)
      psum[i + 1] += psum[i] + vowelcheck(words[i]);

    for (const vector<int>& query : queries) {
      const int l = query[0];
      const int r = query[1];
      ans.push_back(psum[r + 1] - psum[l]);
    }

    return ans;
  }

  bool vowelcheck(const string& word) {
    return isVowel(word.front()) && isVowel(word.back());
  }

  bool isVowel(char c) {
    static constexpr string_view kVowels = "aeiou";
    return kVowels.find(c) != string_view::npos;
  }
};
