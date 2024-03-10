import { useState } from "react";

const GameRow = ({ game, onUpdate })=> {
    const [pointsWhite, setPointsWhite] = useState(game.pointswhite);
    const [pointsBlack, setPointsBlack] = useState(game.pointsblack);
  
 
    const handleChangePointsWhite = (e) => {
      const newPoints = parseFloat(e.target.value);
      setPointsWhite(newPoints);
      onUpdate(game.id, 'pointswhite', newPoints);
    };
 
    const handleChangePointsBlack = (e) => {
      const newPoints = parseFloat(e.target.value);
      setPointsBlack(newPoints);
      onUpdate(game.id, 'pointsblack', newPoints);
    };
  
    return (
      <tr>
        <td>{game.table}</td>
        <td>{game.white.name}</td>
        <td>{game.black.name}</td>
        <td>
          <select value={pointsWhite} onChange={handleChangePointsWhite}>
            <option value="1">1</option>
            <option value="0.5">0.5</option>
            <option value="0">0</option>
          </select>
        </td>
        <td>
          <select value={pointsBlack} onChange={handleChangePointsBlack}>
            <option value="1">1</option>
            <option value="0.5">0.5</option>
            <option value="0">0</option>
          </select>
        </td>
      </tr>
    );
  }
  export default GameRow
  