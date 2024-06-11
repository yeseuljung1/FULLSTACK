import Entry from './Entry';
import { styled } from 'styled-components';

const StSection = styled.section`
  border: 1px black solid;
  border-radius: 10px;
  padding: 20px;
  display: flex;
  flex-direction: column;
  gap: 10px;
`;

const StP = styled.p`
  font-size: x-large;
  background-color: lightcyan;
`;

function EntryList({ entryList, selectedMonth }) {
  return (
    <StSection>
      <StP> {selectedMonth} 월의 가계부</StP>
      {entryList.map((entryData) => {
        const entryMonth = Number(entryData.date.slice(5, 7));

        if (entryMonth === selectedMonth) {
          return <Entry key={entryData.id} entryData={entryData} />;
        }
      })}
    </StSection>
  );
}
export default EntryList;
