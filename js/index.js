function Trie() {
  var root = { };
  return  { add, find };

  function add(contact) { return _add(contact, root); } 

  function _add(contact, trie) {
    var letter = contact.slice(0,1);
    if (!letter)
      return root;

    var branch = trie[letter] || { counter: 0 };
    branch.counter++;
    trie[letter] = branch;
    return add(contact.slice(1), branch);
  }

  function find(contact) { return _find(contact, root) };

  function _find(contact, branch) {
    var letter = contact.slice(0,1);
    if (!letter || !branch)
      return (branch && branch.counter) || 0;

    return find(contact.slice(1), branch[letter]);
  }

}

 // --------------------------------- // 

const trie = Trie();
const fs = require('fs');

const inputs = fs.readFileSync('./input.txt', 'utf8');
const lines = inputs.split('\n');

for (let i = 0; i < lines.length ; i++) {
  const [operator, text] = lines[i].split(' ');
  
  if (operator === 'add')
    trie.add(text);

  if (operator === 'find')
    console.log(trie.find(text));
}
