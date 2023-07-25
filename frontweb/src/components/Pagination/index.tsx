import {ReactComponent as ArrowIcon} from 'assets/images/arrow.svg';
import './styles.css';
import ReactPaginate from 'react-paginate';

type Props = {
    pageCount: number;
    range: number;
    onChange?: (pageNumber: number) => void;
}

const Pagination = ({pageCount, range, onChange} : Props) => {

    return (
          
        <ReactPaginate
            pageCount={pageCount}
            pageRangeDisplayed={range}
            marginPagesDisplayed={1}
            containerClassName="pagination-container"
            pageLinkClassName="pagination-item"
            breakClassName="pagination-item"
            previousClassName="arrow-previous"
            nextClassName="arrow-next"
            activeLinkClassName="pagination-link-active"
            disabledClassName="arrow-inactive"
            onPageChange={(items) => (onChange) ? onChange(items.selected) : {}}

            previousLabel={<ArrowIcon/>}
            nextLabel={<ArrowIcon/>}
        />
        
    );
};

export default Pagination;