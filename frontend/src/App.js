import { useState } from 'react';

import styles from './App.module.css';
import Items from './components/Items/Items';
import Add from './components/Add/Add';


function App() {

  const [items, setItems] = useState(["Buy egg", "Read a book", "Chest workout", "Have dinner with Jayden", "Walk a dog"]);

  const addItem = (newItem) => {
    setItems((prevItems) => [...prevItems, newItem]);
  }

  const deleteItem = (item) => {
    const updatedItemList = items.filter(i => i.name !== item);
    setItems(updatedItemList);
  };

  return (
    <div className={styles.App}>
      <h1 className={styles.header}>To-do list</h1>
      <div className={styles.items}>
        {items.map((item) => (
          <Items key={item} item={item} deleteItem={deleteItem} />
        ))}

      </div>
      <Add addItem={addItem} />
    </div>
  );
}

export default App;
